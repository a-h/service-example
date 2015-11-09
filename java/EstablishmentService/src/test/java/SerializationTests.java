import com.example.establishmentdatamodel.Establishment;
import com.example.establishmentdatamodel.EstablishmentConverter;

import java.io.IOException;

import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

/**
 * Created by ahesketh on 09/11/2015.
 */
public class SerializationTests {
    @Test
    public void it_is_possible_to_convert_json_to_an_establishment_object() throws IOException {
        String json = "{\"FHRSID\": \"526157\", \"LocalAuthorityBusinessID\": \"PI/000003326\", \"BusinessName\": \"1 Temple Pattle\", \"BusinessType\": \"Manufacturers/packers\", \"Busines" +
                "sTypeID\": \"7839\", \"RatingValue\": \"Exempt\", \"RatingKey\": \"fhrs_exempt_en-GB\", \"RatingDate\": \"2012-05-29\", \"LocalAuthorityCode\": \"297\", \"LocalAuthorityN" +
                "ame\": \"Babergh\", \"LocalAuthorityWebSite\": \"http://www.babergh.gov.uk/\", \"LocalAuthorityEmailAddress\": \"food.safety@babergh.gov.uk\", \"Scores\": null, \"S" +
                "chemeType\": \"FHRS\", \"NewRatingPending\": \"False\", \"Geocode\": null}";

        Establishment e = EstablishmentConverter.fromJson(json);

        assertEquals("526157", e.getFHRSID());
    }

    @Test
    public void it_is_possible_to_convert_an_establishment_object_to_json() throws JsonProcessingException {
        Establishment e = new Establishment();
        e.setAddressLine1("Address Line 1");
        e.setAddressLine2("Address Line 2");
        e.setLocalAuthorityBusinessID("Local Authority Business ID");
        e.setBusinessName("Business Name");

        String actual = EstablishmentConverter.toJson(e);

        String expected = "{\r\n" +
                "  \"AddressLine2\" : \"Address Line 2\",\r\n" +
                "  \"AddressLine1\" : \"Address Line 1\",\r\n" +
                "  \"LocalAuthorityBusinessID\" : \"Local Authority Business ID\",\r\n" +
                "  \"BusinessName\" : \"Business Name\"\r\n" +
                "}";

        assertEquals(expected, actual);
    }
}
