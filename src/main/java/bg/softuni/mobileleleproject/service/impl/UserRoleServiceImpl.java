package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.model.entity.UserRoleEntity;
import bg.softuni.mobileleleproject.model.enums.RoleEnum;
import bg.softuni.mobileleleproject.repository.UserRoleRepository;
import bg.softuni.mobileleleproject.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public UserRoleEntity getRole(String name) {
        return this.userRoleRepository.findByName(RoleEnum.valueOf(name));
    }

}