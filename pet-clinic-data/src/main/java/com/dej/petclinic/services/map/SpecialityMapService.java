package com.dej.petclinic.services.map;

import com.dej.petclinic.models.Speciality;
import com.dej.petclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long>  implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        object.setId(super.getNextId());
        return super.save(object.getId(), object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
