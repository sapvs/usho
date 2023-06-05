package io.s3vt.usho.service;

import io.s3vt.usho.model.UshoEntity;
import io.s3vt.usho.repo.UshoRepo;
import io.s3vt.usho.util.UShoGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UshoService {
    private static final ResponseStatusException UshoNotFoundException
            = new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Usho does not exist for requested");
    private static final Logger logger = LoggerFactory.getLogger(UshoService.class);
    @Autowired
    UshoRepo repo;
    @Value("${usho.short.len}")
    private int ushoLength;

    @CachePut(value = "usho")
    public UshoEntity createUsho(String longUrl) {
        logger.info("Creating usho for longurl {}", longUrl);
        return repo.save(new UshoEntity(UShoGenerator.generateShortUrl(ushoLength), longUrl));
    }

    @Cacheable(value = "usho")
    public UshoEntity find(String usho) {
        logger.info("Getting detail of usho {}", usho);
        return repo.findById(usho).orElseThrow(() -> UshoNotFoundException);
    }

    public List<UshoEntity> findAll() {
        logger.info("Getting detail of all usho ");
        return repo.findAll();
    }

    @CacheEvict("usho")
    public void deleteUsho(String usho) {
        logger.info("Deleting Usho {}", usho);
        repo.deleteById(usho);
    }
}
