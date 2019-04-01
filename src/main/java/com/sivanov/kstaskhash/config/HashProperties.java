package com.sivanov.kstaskhash.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "hash")
public class HashProperties {

    private String hashAlgorithm;
    private String hashSalt;

    public String getHashAlgorithm() {
        return hashAlgorithm;
    }

    public String getHashSalt() {
        return hashSalt;
    }

    public void setHashAlgorithm(String hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public void setHashSalt(String hashSalt) {
        this.hashSalt = hashSalt;
    }

    /*
    @Autowired
    public void setHashAlgorithm(@Value("${hash.algorithm:SHA-1}") String hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    @Autowired
    public void setHashSalt(@Value("${hash.salt:nosalt}") String hashSalt) {
        this.hashSalt = hashSalt;
    }
*/
}
