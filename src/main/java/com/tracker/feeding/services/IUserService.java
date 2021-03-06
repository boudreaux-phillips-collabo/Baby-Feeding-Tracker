package com.tracker.feeding.services;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import com.tracker.feeding.web.dto.UserDto;
import com.tracker.feeding.models.PasswordResetToken;
import com.tracker.feeding.models.NewLocationToken;
import com.tracker.feeding.models.User;
import com.tracker.feeding.models.VerificationToken;
import com.tracker.feeding.web.errors.UserAlreadyExistsException;


public interface IUserService {

    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistsException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    void createUserVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(User user, String token);

    User findUserByEmail(String email);

    PasswordResetToken getPasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    Optional<User> getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);

    String validateVerificationToken(String token);

    String generateQRUrl(User user) throws UnsupportedEncodingException;

    User updateUser2FA(boolean use2FA);

    List<String> getUsersFromSessionRegistry();

    NewLocationToken isNewLoginLocation(String username, String ip);

    String isValidNewLocationToken(String token);

    void addUserLocation(User user, String ip);
}
