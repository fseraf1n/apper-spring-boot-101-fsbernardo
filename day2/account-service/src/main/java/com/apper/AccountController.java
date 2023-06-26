package com.apper;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        Account account = accountService.create(request.getFirstName(), request.getLastName(), request.getUsername(), request.getPassword());
        CreateAccountResponse response = new CreateAccountResponse();

        response.setVerificationCode(account.getVerificationCode());
        return response;
    }

    @PutMapping("{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateAccountResponse updateAccount(@RequestBody UpdateAccountRequest request, @PathVariable String accountId) {
        Account account = accountService.update(accountId, request.getFirstName(), request.getLastName(), request.getUsername(), request.getPassword());
        UpdateAccountResponse response = new UpdateAccountResponse();

        response.setLastUpdateDate(account.getLastUpdated());
        return response;
    }

    @DeleteMapping("{accountId}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteAccount(@PathVariable String accountId){
        if (accountService.delete(accountId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{accountId}")
    public GetAccountResponse getAccount(@PathVariable String accountId) {
        Account account = accountService.get(accountId);
        if (account != null) {
            return createGetAccountResponse(account);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "account not found"
            );
        }
    }

    @GetMapping("accountlist")
    public List<GetAccountResponse> getAllAccounts() {
        List<GetAccountResponse> responseList = new ArrayList<>();

        for (Account account : accountService.getAll()) {
            GetAccountResponse response = createGetAccountResponse(account);
            responseList.add(response);
        }

        return responseList;
    }

    private GetAccountResponse createGetAccountResponse(Account account) {
        GetAccountResponse response = new GetAccountResponse();
        response.setBalance(account.getBalance());
        response.setFirstName(account.getFirstName());
        response.setLastName(account.getLastName());
        response.setUsername(account.getUsername());
        response.setRegistrationDate(account.getCreationDate());
        response.setAccountId(account.getId());
        return response;
    }
}
