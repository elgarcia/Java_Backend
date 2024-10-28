package com.elias.Service;

import com.elias.DTO.MedicionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MedicionService {
    @Value("${api.base-url}")
    private String  apiBaseUrl;

    @Autowired
    private RestTemplate    restTemplate;

    public List<MedicionDTO>    getAllMediciones() {
        ResponseEntity<List<MedicionDTO>>   response = restTemplate.exchange(
                apiBaseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MedicionDTO>>() {}
        );
        return (response.getBody());
    }

    public List<MedicionDTO>    filterByAny(Short any){
        String url = apiBaseUrl + "/filter/" + any;
        ResponseEntity<List<MedicionDTO>>   response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MedicionDTO>>() {}
        );
        return (response.getBody());
    }

    public MedicionDTO  getMedicionById(Long id){
        String url = apiBaseUrl + "/" + id;
        return (restTemplate.getForObject(url, MedicionDTO.class));
    }

    public MedicionDTO  createMedicion(MedicionDTO medicion){
        return (restTemplate.postForObject(apiBaseUrl, medicion, MedicionDTO.class));
    }

    public void updateMedicion(Long id, MedicionDTO medicion){
        String  url = apiBaseUrl + "/" + id;
        restTemplate.put(url, medicion);
    }

    public void deleteMedicion(Long id){
        String url = apiBaseUrl + "/" + id;
        restTemplate.delete(url);
    }

    public List<Short>  getAvailableYears() {
        ResponseEntity<List<Short>> responseEntity = restTemplate.exchange(
                apiBaseUrl + "/years",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Short>>() {}
        );

        return responseEntity.getBody();
    }
}
