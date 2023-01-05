package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> update(Long id, User user) {
        return this.findById(id)
                .map(userFromDb -> {
                    if (user.getEmail() != null) {
                        userFromDb.setEmail(user.getEmail());
                    }
                    if (user.getFirstName() != null) {
                        userFromDb.setFirstName(user.getFirstName());
                    }
                    if (user.getLastName() != null) {
                        userFromDb.setLastName(user.getLastName());
                    }

                    return userFromDb;
                }).flatMap(this.userRepository::save);
    }

    public Mono<User> create(User user) {
        return userRepository.save(user);
    }


    public Mono delete(Long id) {
        return this.findById(id)
                .flatMap(this.userRepository::delete);
    }
}
