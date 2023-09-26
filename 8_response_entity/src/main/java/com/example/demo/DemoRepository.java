package com.example.demo;

import java.util.Optional;

import org.springframework.stereotype.Component;


@Component
public class DemoRepository {
    final Demo demo = new Demo("1", "Demo");
    public Optional<Demo> findById(String id) {
        if (!id.contentEquals(demo.getId())) {
            return Optional.empty(); 
        }
        return Optional.of(demo);
    }

    public Optional<Demo> findByTitle(String title) {
        if (!title.contentEquals(demo.getTitle())) {
            return Optional.empty();
        }
        return Optional.of(demo);
    }

    public Demo save(Demo demo) {
        long unixTime = System.currentTimeMillis() / 1000L;
        demo.setId(Long.toString(unixTime));
        return demo;
    }

    public void deleteById(String id) {}
}
