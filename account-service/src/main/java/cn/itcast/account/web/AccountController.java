package cn.itcast.account.web;

import cn.itcast.account.service.AccountService;
import cn.itcast.account.service.AccountTCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("account")
public class AccountController {

//    @Autowired
//    private AccountService accountService;

    @Autowired
    private AccountTCCService accountTCCService;  // 使用Seata TCC模式

    @PutMapping("/{userId}/{money}")
    public ResponseEntity<Void> deduct(@PathVariable("userId") String userId, @PathVariable("money") Integer money){
//        accountService.deduct(userId, money);
        accountTCCService.deduct(userId, money);
        return ResponseEntity.noContent().build();
    }
}
