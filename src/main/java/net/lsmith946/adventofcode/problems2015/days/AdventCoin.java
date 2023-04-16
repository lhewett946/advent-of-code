package net.lsmith946.adventofcode.problems2015.days;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public record AdventCoin(String secretKey) {

    public Long mine(String targetHashStart) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            long currentNumber = 0;
            byte[] currentHashBytes;
            String currentHash;
            do {
                currentNumber++;
                String hashInput = secretKey + currentNumber;
                currentHashBytes = md5.digest(hashInput.getBytes(StandardCharsets.UTF_8));
                StringBuilder sb = new StringBuilder();
                // performance optimisation, only process the exact number of bytes that we need to in order to
                // generate enough characters at the start of the hex string
                int bytesToConvert = (int) Math.ceil((double) targetHashStart.length() / 2.0);
                for (int i = 0; i < bytesToConvert; i++) {
                    sb.append(HexFormat.of().toHexDigits(currentHashBytes[i]));
                }
                currentHash = sb.toString();
            } while (!currentHash.startsWith(targetHashStart));
            return currentNumber;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
