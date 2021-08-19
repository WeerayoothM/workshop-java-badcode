package badcode;

import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {

        Integer speakerId;
        String[] domains = {"gmail.com", "live.com"};

        if (!haveValue(speaker.getFirstName())) {
            throw new ArgumentNullException("First name is required.");
        }

        if (!haveValue(speaker.getLastName())) {
            throw new ArgumentNullException("Last name is required.");
        }

        if (!haveValue(speaker.getEmail())) {
            throw new ArgumentNullException("Email is required.");
        }

        String emailDomain = getEmailDomain(speaker.getEmail()); // Avoid ArrayIndexOutOfBound
        if (isValidEmail(domains, emailDomain)) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }

        int experience = speaker.getExp();
        speaker.setRegistrationFee(getFee(experience));
        try {
            speakerId = repository.saveSpeaker(speaker);
        } catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }

        return speakerId;
    }

    private boolean isValidEmail(String[] domains, String emailDomain) {
        return Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() != 1;
    }

    private boolean haveValue(String value){
        return value != null && !value.trim().equals("");
    }

    int getFee(int experienceYear) {
        int fee = 0;
        if (experienceYear <= 1) {
            fee = 500;
        } else if (experienceYear <= 3) {
            fee = 250;
        } else if (experienceYear <= 5) {
            fee = 100;
        } else if (experienceYear <= 9) {
            fee = 50;
        }
        return fee;
    }

    public String getEmailDomain(String email) {
        String[] inputs = email.trim().split("@");
        if (inputs.length == 2) return inputs[1];
        throw new DomainEmailInvalidException();
    }

}
