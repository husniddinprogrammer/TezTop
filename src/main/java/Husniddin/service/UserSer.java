package Husniddin.service;

import Husniddin.entity.User;
import Husniddin.service.dto.UserDTO;
import Husniddin.service.vm.UserVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserSer {
    public Page<UserDTO> getAll(Pageable pageable);
    public UserDTO getById(Long id) throws Exception;
    public UserDTO create(UserVM data) throws Exception;
    public UserDTO update(UserVM data) throws Exception;
    public void delete(UserVM data);
    public void deleteById(Long id);
    UserDTO getByLogin(String username);
    UserDTO getCurrentUser();
    public UserDTO getProfile();
    public UserDTO getProfileUpdate(UserVM data);
    public UserDTO getProfileUpdateCreator(User data);
}
