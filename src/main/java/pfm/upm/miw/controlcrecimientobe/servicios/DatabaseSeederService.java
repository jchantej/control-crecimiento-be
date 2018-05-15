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

import pfm.upm.miw.controlcrecimientobe.daos.IPersonaDao;
import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioDao;
import pfm.upm.miw.controlcrecimientobe.entidades.Usuario;

@Service
public class DatabaseSeederService {

    @Value("${cc.admin.username}")
    private String username;

    @Value("${cc.admin.password}")
    private String password;

    @Value("${cc.databaseSeeder.ymlFileName:#{null}}")
    private Optional<String> ymlFileName;

    @Autowired
    private IUsuarioDao iUsuarioDao;

    @Autowired
    private IPersonaDao iPersonaDao;

    @PostConstruct
    public void seedDatabase() {
        if (ymlFileName.isPresent()) {
            this.deleteAllAndCreateAdmin();
            try {
                this.seedDatabase(ymlFileName.get());
            } catch (IOException e) {
  
                LogManager.getLogger(this.getClass()).error("File " + ymlFileName + " doesn't exist or can't be opened");
            }
        } else {
            this.createAdminIfNotExist();
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
      
        // -----------------------------------------------------------------------

        LogManager.getLogger(this.getClass()).warn("------------------------- Seed: " + ymlFileName + "-----------");
    }

    public void deleteAllAndCreateAdmin() {
        LogManager.getLogger(this.getClass()).warn("------------------------- delete All And Create Admin-----------");
        // Delete Repositories -----------------------------------------------------
        this.iUsuarioDao.deleteAll();
        this.iPersonaDao.deleteAll();

        this.createAdminIfNotExist();
        // -----------------------------------------------------------------------
    }

    public void createAdminIfNotExist() {
        if (this.iUsuarioDao.findByUsername(this.username) == null) {
            Usuario usuario = new Usuario(this.username, this.password, "","","","");
           //TODO: falta agregar el rol
            this.iUsuarioDao.save(usuario);
        }
    }

}
