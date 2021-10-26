package com.san.webappsan.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.san.webappsan.domain.Post;
import com.san.webappsan.domain.User;
import com.san.webappsan.dto.AuthorDTO;
import com.san.webappsan.dto.CommentDTO;
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

        userRepository.saveAll(Arrays.asList(maria, alex, jack));

        Post post1 = new Post(null, sdf.parse("26/10/2021"), "Kyrie Irving doesn't want to vaccinate.", "Shame on Kyrie, his selfishness attitude is damaging his team, Brooklyn Nets, to get any chance of going to play-offs this season.", new AuthorDTO(alex));
        Post post2 = new Post(null, sdf.parse("25/10/2021"), "LaMelo Ball is compared to Magic Johnson.", "I really think that is wrong to compare players from different generation, but Melo has the magic too.", new AuthorDTO(alex));

        CommentDTO c1 = new CommentDTO("Yeah, I really think Kyrie Irving is destroy his own reputation (at least pulverizing it) and creating instabillity for his team", sdf.parse("26/10/2021"), new AuthorDTO(jack));
        CommentDTO c2 = new CommentDTO("I dont know, maybe his just tryna demonstrate his individual freedom.", sdf.parse("26/10/2021"), new AuthorDTO(maria));
        CommentDTO c3 = new CommentDTO("Hell no, that aint the question, Kyrie is, doubtless, creating an instabillity, and get vaxx or not is out of the question of 'Individual Freedom', so, dont talk shit, sis! ", sdf.parse("26/10/2021"), new AuthorDTO(jack));
        
        CommentDTO c4 = new CommentDTO("I think is too early to say that, but man, he got talent!", sdf.parse("14/11/2021"), new AuthorDTO(jack));
        
        post1.getComments().addAll(Arrays.asList(c1, c2, c3));
        post2.getComments().addAll(Arrays.asList(c4));

        postRepository.saveAll(Arrays.asList(post1, post2));

        alex.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(alex);
    }
    
}
