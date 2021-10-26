package com.san.webappsan.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.san.webappsan.domain.Post;
import com.san.webappsan.domain.User;
import com.san.webappsan.repository.PostRepository;
import com.san.webappsan.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User jack = new User(null, "Jack Johnson", "jack@gmail.com");

        Post post1 = new Post(null, sdf.parse("26/10/2021"), "Kyrie Irving doesn't want to vaccinate.", "Shame on Kyrie, his selfishness attitude is damaging his team, Brooklyn Nets, to get any chance of going to play-offs this season.", alex);
        Post post2 = new Post(null, sdf.parse("25/10/2021"), "LaMelo Ball is compared to Magic Johnson.", "I really think that is wrong to compare players from different generation, but Melo has the magic too.", alex);

        userRepository.saveAll(Arrays.asList(maria, alex, jack));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
    
}
