package pfm.upm.miw.controlcrecimientobe.servicios;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import pfm.upm.miw.controlcrecimientobe.daos.IControlCrecimientoDao;
import pfm.upm.miw.controlcrecimientobe.daos.IPercentilCrecimientoDao;
import pfm.upm.miw.controlcrecimientobe.daos.IPercentilOmsDao;
import pfm.upm.miw.controlcrecimientobe.daos.IPersonaDao;
import pfm.upm.miw.controlcrecimientobe.daos.IRolDao;
import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioDao;
import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioRolDao;
import pfm.upm.miw.controlcrecimientobe.entidades.Rol;
import pfm.upm.miw.controlcrecimientobe.entidades.Usuario;
import pfm.upm.miw.controlcrecimientobe.entidades.UsuarioRol;

@Service
public class DatabaseSeederService {

    @Value("${cc.admin.username}")
    private String username;

    @Value("${cc.admin.password}")
    private String password;
    
    @Value("${cc.admin.codigo.rol}")
    private String codigoRol;
    
    @Value("${cc.admin.nombre.rol}")
    private String nombreRol;
    
    @Value("${cc.costumer.codigo.rol}")
    private String codigoCostumerRol;
    
    @Value("${cc.costumer.nombre.rol}")
    private String nombreCostumerRol;

    @Value("${cc.databaseSeeder.ymlFileName:#{null}}")
    private Optional<String> ymlFileName;

    @Autowired
    private IUsuarioDao iUsuarioDao;

    @Autowired
    private IPersonaDao iPersonaDao;

    @Autowired
    private IControlCrecimientoDao iControlCrecimientoDao;

    @Autowired
    private IPercentilOmsDao iPercentilOmsDao;

    @Autowired
    private IPercentilCrecimientoDao iPercentilCrecimientoDao;
    
    @Autowired
    private IRolDao iRolDao;
    
    @Autowired
    private IUsuarioRolDao iUsuarioRolDao;

    @PostConstruct
    public void seedDatabase() {
        if (ymlFileName.isPresent()) {
            this.deleteAllAndCreateAdmin();
            this.createRolCostumerIfNotExist();
            try {
                this.seedDatabase(ymlFileName.get());
            } catch (IOException e) {

                LogManager.getLogger(this.getClass()).error("File " + ymlFileName + " doesn't exist or can't be opened");
            }
        } else {
            this.createAdminIfNotExist();
            this.createRolCostumerIfNotExist();
        }
    }

    public void seedDatabase(String ymlFileName) throws IOException {
        assert ymlFileName != null && !ymlFileName.isEmpty();
        Yaml yamlParser = new Yaml(new Constructor(DatabaseGraph.class));
        InputStream input = new ClassPathResource(ymlFileName).getInputStream();
        DatabaseGraph tpvGraph = (DatabaseGraph) yamlParser.load(input);

        // Save Repositories -----------------------------------------------------
        if (tpvGraph.getUsuarioList() != null) {
            this.iUsuarioDao.saveAll(tpvGraph.getUsuarioList());
        }
        if (tpvGraph.getPersonaList() != null) {
            this.iPersonaDao.saveAll(tpvGraph.getPersonaList());
        }
        if (tpvGraph.getPersonaList() != null) {
            this.iPercentilOmsDao.saveAll(tpvGraph.getPercentilOmsList());
        }
        
      /*  if (tpvGraph.getRolList() != null) {
            this.iRolDao.saveAll(tpvGraph.getRolList());
        }*/

        // -----------------------------------------------------------------------

        LogManager.getLogger(this.getClass()).warn("------------------------- Seed: " + ymlFileName + "-----------");
    }

    public void deleteAllAndCreateAdmin() {
        LogManager.getLogger(this.getClass()).warn("------------------------- delete All And Create Admin-----------");
        // Delete Repositories -----------------------------------------------------
        this.iUsuarioRolDao.deleteAll();
        this.iUsuarioDao.deleteAll();
        this.iRolDao.deleteAll();
        this.iPercentilCrecimientoDao.deleteAll();
        this.iPercentilOmsDao.deleteAll();
        this.iControlCrecimientoDao.deleteAll();
        this.iPersonaDao.deleteAll();

        this.createAdminIfNotExist();
        this.createRolCostumerIfNotExist();
        // -----------------------------------------------------------------------
    }

    public void createAdminIfNotExist() {
        LogManager.getLogger(this.getClass()).info("------------------------- llega a admin rol Admin-----------");
        if (this.iUsuarioDao.findByUsername(this.username) == null) {
            Usuario usuario = new Usuario(this.username, this.password, "", "", "", "");
            Rol rol = new Rol(this.codigoRol, this.nombreRol);
            UsuarioRol usuarioRol = new UsuarioRol();
            this.iRolDao.save(rol);
            this.iUsuarioDao.save(usuario);
            usuarioRol.setRol(rol);
            usuarioRol.setUsuario(usuario);
            this.iUsuarioRolDao.save(usuarioRol);
        }
        
    }
    
    public void createRolCostumerIfNotExist() {
        LogManager.getLogger(this.getClass()).info("------------------------- Entra a crear el rol Costumer-----------");
        if (this.iRolDao.findByCodigo(this.codigoCostumerRol) == null) {
            Rol rol = new Rol(this.codigoCostumerRol, this.nombreCostumerRol);
            this.iRolDao.save(rol);
        }
    }

}
