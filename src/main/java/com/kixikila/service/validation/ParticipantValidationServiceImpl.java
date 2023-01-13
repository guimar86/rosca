package com.kixikila.service.validation;

import com.kixikila.model.Participant;
import fr.marcwrobel.jbanking.iban.Iban;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static com.kixikila.util.Constants.*;

@Service
public class ParticipantValidationServiceImpl implements ParticipantValidationService<Participant> {
    @Override
    public Map<String, Object> validate(Participant participant) {

        Map<String,Object> validations=new HashMap<>();

        if (!validateEmailAddress(participant.getEmail())){
            validations.put("Email",INVALID_EMAIL);
        }

        if (!validateIban(participant.getIban())){
            validations.put("Iban",INVALID_IBAN);
        }

        if (!validateTelephoneNumber(participant.getTelephoneNumber())){
            validations.put("Telephone",INVALID_TELEPHONE_NUMBER);
        }

        return validations;
    }

    private boolean validateEmailAddress(String email){
        var regexPattern = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
                + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";

        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }

    private boolean validateIban(String iban){

        return Iban.isValid(iban);
    }

    private boolean validateTelephoneNumber(String telephoneNumber){

        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

        return Pattern.compile(patterns)
                .matcher(telephoneNumber)
                .matches();
    }

}
