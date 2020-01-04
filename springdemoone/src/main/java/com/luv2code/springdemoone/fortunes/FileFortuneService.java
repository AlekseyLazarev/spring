package com.luv2code.springdemoone.fortunes;

import com.luv2code.springdemoone.interfaces.FortuneService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 03.01.2020
 */
@Component
public class FileFortuneService implements FortuneService {
    @Value("${filefortune}")
    private String filePath;
    private List<String> fortunes;
    private final Random random = new Random();

    @PostConstruct
    private void loadTheFortunesFile() {
        File theFile = new File(this.filePath);
        this.fortunes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(theFile))) {
            String tempLine;
            while ((tempLine = br.readLine()) != null) {
                this.fortunes.add(tempLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        return this.fortunes.get(this.random.nextInt(this.fortunes.size()));
    }
}
