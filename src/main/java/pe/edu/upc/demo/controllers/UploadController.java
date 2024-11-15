package pe.edu.upc.demo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.upc.demo.serviceinterfaces.IUploadService;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@RestController
@RequestMapping("media")
//@PreAuthorize("hasAnyAuthority('USUARIO','ADMIN','EMPRENDIMIENTO')")
public class UploadController {
    //@Autowired
    private final IUploadService iuS;
    //@Autowired
    private final HttpServletRequest request;

    public UploadController(IUploadService iuS, HttpServletRequest request) {
        this.iuS = iuS;
        this.request = request;
    }

    @PostMapping("upload")
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        String path = iuS.store(multipartFile);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String url = ServletUriComponentsBuilder
                .fromHttpUrl(host)
                .path("/media/")
                .path(path)
                .toUriString();
        return Map.of("url", url);
    }
    @DeleteMapping("delete/{filename:.+}")
    public ResponseEntity<?> deleteFile(@PathVariable String filename) {
        try {
            iuS.delete(filename);
            return ResponseEntity.ok().body("File deleted successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to delete file.");
        }
    }
    @GetMapping("{filename:.+}")
    //@PreAuthorize("hasAnyAuthority('CLIENTE','ADMIN')")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
        Resource file = iuS.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);
    }
}