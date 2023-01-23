package com.kixikila.service.impl;

import com.kixikila.model.Participant;
import com.kixikila.model.Rosca;
import com.kixikila.repository.RoscaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class RoscaServiceTest {

    @Autowired
    private RoscaRepository repository;
    private Rosca rosca;

    @BeforeEach
    public void fillH2Database() {
        Participant participant_1 = Participant.builder()
                .email("test1@gmail.com")
                .iban("FR2531682128768051490609537")
                .IdentificationNumber("100101919100")
                .telephoneNumber("00351959493939")
                .name("John Doe")
                .build();
        Participant participant_2 = Participant.builder()
                .email("test2@gmail.com")
                .iban("FR2531682128768051490609537")
                .IdentificationNumber("100101919100")
                .telephoneNumber("00351959493939")
                .name("John Doe")
                .build();

        List<Participant> participantList = Arrays.asList(participant_1, participant_2);

        rosca = Rosca.builder()
                .name("Rosca test")
                .currentTurn(1)
                .contributionAmount(2300)
                .participants(participantList)
                .build();


    }

    @Test
    public void RoscaRepository_list_returnsList() {
        repository.save(rosca);
        var list = repository.findAll();
        Assertions.assertThat(list).isNotEmpty();
    }

    @Test
    public void createRosca() {

        Assertions.assertThat(rosca).isNotNull();
        //act
        var result = repository.save(rosca);
    }

    @Test
    public void findRoscaById() {

        var result = repository.save(rosca);
        var id = rosca.getId();
        var foundRosca = repository.findById(id);

        Assertions.assertThat(foundRosca.get()).isNotNull();

    }
}
