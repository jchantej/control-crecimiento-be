package pfm.upm.miw.controlcrecimientobe.recursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pfm.upm.miw.controlcrecimientobe.cotroladores.UploadFileController;

@RestController
@RequestMapping(UploadFileRecurso.FILE)
public class UploadFileRecurso {
    public static final String FILE = "/file";

    public static final String UPLOAD = "/upload";
    public static final String FILENAME = "/{filename}";

    @Autowired
    private UploadFileController uploadFileController;

    @PostMapping(value = UPLOAD)
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {

        return uploadFileController.handleFileUpload(file);
    }

    @GetMapping(value = FILENAME)
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {

        return uploadFileController.getFile(filename);
    }
}
