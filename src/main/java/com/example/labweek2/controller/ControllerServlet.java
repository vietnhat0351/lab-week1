package com.example.labweek2.controller;

import com.example.labweek2.entities.Account;
import com.example.labweek2.entities.GrantAccess;
import com.example.labweek2.entities.Role;
import com.example.labweek2.service.AccountService;
import com.example.labweek2.service.GrantAccessService;
import com.example.labweek2.service.RoleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AccountServlet", value = "/account")
public class ControllerServlet extends HttpServlet {

    RoleService roleService = new RoleService();
    AccountService accountService = new AccountService();

    private GrantAccessService grantAccessService = new GrantAccessService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acction = req.getParameter("action");

        if(acction.equalsIgnoreCase("login")) {
            handleLogin(req, resp);
        }

        if(acction.equalsIgnoreCase("addaccount")) {
            handleAddAcount(req, resp);
            load(req, resp);
        }

        if(acction.equalsIgnoreCase("deleteaccount")) {
            handleDeleteAccount(req, resp);
            load(req, resp);
        }

        if(acction.equalsIgnoreCase("grantrole")) {
            handleGrantRole(req,resp);
            load(req, resp);
        }

    }

    public void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        Account account = accountService.findAccountByEmailPassword(email, password);
        if(account != null) {
            Role accountRole = roleService.getAccountRole(account.getAccountId());
            Boolean isAdmin = false;
            if(accountRole.getRoleName().equalsIgnoreCase("admin") && accountRole.getStatus() == 1) {
                isAdmin = true;
            }
            if(isAdmin) {
                load(req, resp);
            } else {
                req.setAttribute("account", account);
                getServletContext().getRequestDispatcher("/user-page.jsp").forward(req, resp);
            }
        } else {
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<h1>sai email hoac passwod</h1>");
        }
    }

    public void handleAddAcount(HttpServletRequest req, HttpServletResponse resp) {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("pwd");
        String roleString = req.getParameter("role");

        Account account = new Account(fullName, password, email, phone, 1);
        GrantAccess grantAccess = null;
        GrantAccess grantAccess1 = null;
        accountService.add(account);
        if(roleString.equalsIgnoreCase("admin")) {
            Role role = new Role("1");
            Role role1 = new Role("2");
            grantAccess = new GrantAccess(role, account, true, "???");
            grantAccess1 = new GrantAccess(role1, account, false, "???");
        } else {
            Role role = new Role("2");
            Role role1 = new Role("1");
            grantAccess = new GrantAccess(role, account, true, "???");
            grantAccess1 = new GrantAccess(role1, account, false, "???");
        }
        grantAccessService.add(grantAccess);
        grantAccessService.add(grantAccess1);
    }


    public void handleDeleteAccount(HttpServletRequest req, HttpServletResponse resp) {
        String accountId = req.getParameter("accountId");
        Account account = accountService.findById(Integer.parseInt(accountId));
        accountService.delete(account);
    }

    public void handleGrantRole(HttpServletRequest req, HttpServletResponse resp) {
        String accountId = req.getParameter("accountId");
        Account account = accountService.findById(Integer.parseInt(accountId));
        String role = req.getParameter("role");
        grantAccessService.grantRole(account, role);
    }

    public void load(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Account, Role> map = new LinkedHashMap<>();
        List<Account> accountList = accountService.getAllAcount();
        for (Account acc : accountList) {
            Role role = roleService.getAccountRole(acc.getAccountId());
            map.put(acc,role);
        }
        req.setAttribute("accountRole", map);
        getServletContext().getRequestDispatcher("/admin-page.jsp").forward(req, resp);
    }
}
