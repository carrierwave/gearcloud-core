package com.gearcloud.core.bootstrap;

import com.gearcloud.core.model.Affinity;
import com.gearcloud.core.model.Possession;
import com.gearcloud.core.model.Profile;
import com.gearcloud.core.repositories.PossessionRepository;
import com.gearcloud.core.repositories.ProfileRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProfileRepository profileRepository;
    private PossessionRepository possessionRepository;

    public DevBootstrap(ProfileRepository profileRepository, PossessionRepository possessionRepository) {
        this.profileRepository = profileRepository;
        this.possessionRepository = possessionRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //adrian
        Profile adrian = new Profile( "Adrian McPhee", "I am Adrian McPhee.");
        Possession maybach = new Possession(adrian, Affinity.OWNED, "Maybach Lester P90");
        Possession duesenberg = new Possession(adrian, Affinity.OWNED, "Duesenberg Fullerton CC");


        profileRepository.save(adrian);
        possessionRepository.save(maybach);
        possessionRepository.save(duesenberg);

        //woodrow
        Profile woodrow = new Profile ("Woodrow Wegkamp", "I am Woodymen.");
        Possession gibson = new Possession(woodrow, Affinity.OWNED, "Gibson Les Paul Less Plus");
        Possession prs = new Possession(woodrow, Affinity.OWNED, "PRS CE22");

        profileRepository.save(woodrow);
        possessionRepository.save(gibson);
        possessionRepository.save(prs);

    }
}
