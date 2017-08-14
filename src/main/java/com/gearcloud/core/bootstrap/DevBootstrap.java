package com.gearcloud.core.bootstrap;

import com.gearcloud.core.model.*;
import com.gearcloud.core.repositories.PossessionRepository;
import com.gearcloud.core.repositories.ProductRepository;
import com.gearcloud.core.repositories.ProfileRepository;
import com.gearcloud.core.repositories.StatementRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProfileRepository profileRepository;
    private PossessionRepository possessionRepository;
    private ProductRepository productRepository;
    private StatementRepository statementRepository;

    public DevBootstrap(ProfileRepository profileRepository, PossessionRepository possessionRepository, ProductRepository productRepository, StatementRepository statementRepository) {
        this.profileRepository = profileRepository;
        this.possessionRepository = possessionRepository;
        this.productRepository = productRepository;
        this.statementRepository = statementRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //adrian
        Profile adrian = new Profile( "Adrian McPhee", "I am Adrian McPhee.");

        Product lester = new Product("Maybach", "Lester P90","Guitar Gear");
        Product fullerton = new Product("Duesenberg", "Fullerton CC", "Guitar Gear");

        Possession maybach = new Possession(adrian, Affinity.OWNED, lester);
        Possession duesenberg = new Possession(adrian, Affinity.OWNED, fullerton);

        Statement s1 = new Statement("Better than a Les Paul!");
        Statement s2 = new Statement ("Better than a 335!");

        s1.setPossession(maybach);
        s2.setPossession(duesenberg);

        profileRepository.save(adrian);
        productRepository.save(lester);
        productRepository.save(fullerton);
        possessionRepository.save(maybach);
        possessionRepository.save(duesenberg);
        statementRepository.save(s1);
        statementRepository.save(s2);

        //woodrow
        Profile woodrow = new Profile ("Woodrow Wegkamp", "I am Woodymen.");

        Product lespaul = new Product("Gibson", "Les Paul Less Plus", "Guitar Gear");
        Product ce22 = new Product("PRS", "CE22", "Guitar Gear");


        Possession gibson = new Possession(woodrow, Affinity.OWNED, lespaul);
        Possession prs = new Possession(woodrow, Affinity.OWNED, ce22);

        Statement s3 = new Statement("The best Les Paul!");
        Statement s4 = new Statement ("My favourite PRS!");

        s3.setPossession(gibson);
        s4.setPossession(prs);

        profileRepository.save(woodrow);
        productRepository.save(lespaul);
        productRepository.save(ce22);
        possessionRepository.save(gibson);
        possessionRepository.save(prs);
        statementRepository.save(s3);
        statementRepository.save(s4);

    }
}
