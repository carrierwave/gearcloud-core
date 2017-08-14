package com.gearcloud.core.bootstrap;

import com.gearcloud.core.model.*;
import com.gearcloud.core.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProfileRepository profileRepository;
    private PossessionRepository possessionRepository;
    private ProductRepository productRepository;
    private StatementRepository statementRepository;
    private BrandRepository brandRepository;
    private CommunityRepository communityRepository;

    public DevBootstrap(ProfileRepository profileRepository, PossessionRepository possessionRepository, ProductRepository productRepository, StatementRepository statementRepository, BrandRepository brandRepository, CommunityRepository communityRepository) {
        this.profileRepository = profileRepository;
        this.possessionRepository = possessionRepository;
        this.productRepository = productRepository;
        this.statementRepository = statementRepository;
        this.brandRepository = brandRepository;
        this.communityRepository = communityRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //adrian
        Profile adrian = new Profile( "Adrian McPhee", "I am Adrian McPhee.");

        Brand maybach = new Brand("Maybach");
        Brand duesenberg = new Brand("Duesenberg");

        Community guitarGear = new Community("Guitar Gear", "All about the Guitar Gear");

        Product lester = new Product(maybach, "Lester P90",guitarGear);
        Product fullerton = new Product(duesenberg, "Fullerton CC", guitarGear);

        Possession maybachLester = new Possession(adrian, Affinity.OWNED, lester);
        Possession duesenbergFullerton = new Possession(adrian, Affinity.OWNED, fullerton);

        Statement s1 = new Statement("Better than a Les Paul!");
        Statement s2 = new Statement ("Better than a 335!");

        s1.setPossession(maybachLester);
        s2.setPossession(duesenbergFullerton);

        communityRepository.save(guitarGear);

        brandRepository.save(maybach);
        brandRepository.save(duesenberg);

        profileRepository.save(adrian);
        productRepository.save(lester);
        productRepository.save(fullerton);
        possessionRepository.save(maybachLester);
        possessionRepository.save(duesenbergFullerton);
        statementRepository.save(s1);
        statementRepository.save(s2);

        //woodrow
        Profile woodrow = new Profile ("Woodrow Wegkamp", "I am Woodymen.");

        Brand gibson = new Brand("Gibson");
        Brand prs = new Brand ("PRS");

        Product lespaul = new Product(gibson, "Les Paul Less Plus", guitarGear);
        Product ce22 = new Product(prs,"CE22", guitarGear);

        Possession gibsonLespaul = new Possession(woodrow, Affinity.OWNED, lespaul);
        Possession prsCe22 = new Possession(woodrow, Affinity.OWNED, ce22);

        Statement s3 = new Statement("The best Les Paul!");
        Statement s4 = new Statement ("My favourite PRS!");

        s3.setPossession(gibsonLespaul);
        s4.setPossession(prsCe22);

        brandRepository.save(gibson);
        brandRepository.save(prs);

        profileRepository.save(woodrow);
        productRepository.save(lespaul);
        productRepository.save(ce22);
        possessionRepository.save(gibsonLespaul);
        possessionRepository.save(prsCe22);
        statementRepository.save(s3);
        statementRepository.save(s4);

    }
}
