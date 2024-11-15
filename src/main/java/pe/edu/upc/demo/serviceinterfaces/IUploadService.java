package pe.edu.upc.demo.serviceinterfaces;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IUploadService {
    void init() throws IOException;
    String store(MultipartFile file);
    Resource loadAsResource(String filename);
    void delete(String filename) throws IOException;
}
