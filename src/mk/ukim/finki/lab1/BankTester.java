package mk.ukim.finki.lab1;

import java.util.*;
import java.util.stream.Collectors;

public class BankTester {

    static class Account {
        Account() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Account account = (Account) o;
            return id == account.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        private String name;
        long id;
        private String balance;

        public Account(String name, String balance) {
            this.name = name;
            this.balance = balance;
            Random random = new Random();
            id = random.nextLong();
        }

        public String getName() {
            return name;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public long getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Name: " + name + '\n' + "Balance: " + balance + '\n';
        }
    }

    abstract static class Transaction {

        private final long fromId;
        private final long toId;
        private final String amount;

        private final String description;

        public Transaction(long fromId, long toId, String description, String amount) {
            this.fromId = fromId;
            this.toId = toId;
            this.description = description;
            this.amount = amount;
        }

        public long getFromId() {
            return fromId;
        }

        public long getToId() {
            return toId;
        }

        public String getDescription() {
            return description;
        }

        public String getAmount() {
            return amount;
        }
    }

    static class FlatAmountProvisionTransaction extends Transaction {

        private final String flatProvision;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FlatAmountProvisionTransaction that = (FlatAmountProvisionTransaction) o;
            return Objects.equals(flatProvision, that.flatProvision);
        }

        @Override
        public int hashCode() {
            return Objects.hash(flatProvision);
        }

        public FlatAmountProvisionTransaction(long fromId, long toId, String amount, String flatProvision) {
            super(fromId, toId, "FlatAmount", amount);
            this.flatProvision = flatProvision;
        }

        public String getFlatAmount() {
            return flatProvision;
        }
    }

    static class FlatPercentProvisionTransaction extends Transaction {
        private final int centsPerDolar;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FlatPercentProvisionTransaction that = (FlatPercentProvisionTransaction) o;
            return centsPerDolar == that.centsPerDolar;
        }

        @Override
        public int hashCode() {
            return Objects.hash(centsPerDolar);
        }

        public FlatPercentProvisionTransaction(long fromId, long toId, String amount, int centsPerDolar) {
            super(fromId, toId, "FlatPercent", amount);
            this.centsPerDolar = centsPerDolar;
        }

        public int getPercent() {
            return centsPerDolar;
        }
    }

    static class Bank {
        private String name;
        private Account[] accounts;

        private double totalProvisions;
        private double totalTransfers;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Account[] getAccounts() {
            return accounts;
        }

        public void setAccounts(Account[] accounts) {
            this.accounts = accounts;
        }

        public Bank(String name, Account[] accounts) {
            this.name = name;
            this.accounts = accounts;
            this.totalProvisions = 0.00;
            this.totalTransfers = 0.00;
        }

        boolean makeTransaction(Transaction transaction) {
            boolean flagFrom = false;
            boolean flagTo = false;
            Account accountFrom = new Account();
            Account accountTo = new Account();
            for (Account acc : accounts) {
                if (acc.getId() == transaction.fromId) {
                    accountFrom = acc;
                    flagFrom = true;
                }
                if (acc.getId() == transaction.toId) {
                    flagTo = true;
                    accountTo = acc;
                }
            }
            if (checkForId(accountFrom.getBalance(), transaction.getAmount()) && flagTo && flagFrom) {
                transferMoney(accountFrom, accountTo, transaction);
                return true;
            } else return false;
        }

        boolean checkForId(String s1, String s2) {
            double d1 = Double.parseDouble(s1.replace("$", ""));
            double d2 = Double.parseDouble(s2.replace("$", ""));
            if (d1 >= d2)
                return true;
            else return false;
        }

        void transferMoney(Account accountFrom, Account accountTo, Transaction transaction) {
            double totalTransaction = Double.parseDouble(transaction.getAmount().replace("$", ""));
            totalTransfers = totalTransaction;
            if (transaction.getDescription().equals("FlatAmount")) {
                totalTransaction += 10;
                totalProvisions += 10;
            } else if (transaction.getDescription().equals("FlatPercent")) {
                int prov = (int) (totalTransaction * 0.5);
                totalTransaction += (double) prov;
                totalProvisions += prov;
            }
            double from = Double.parseDouble(accountFrom.getBalance().replace("$", "")) - totalTransaction;
            double to = Double.parseDouble(accountTo.getBalance().replace("$", ""));
            to += Double.parseDouble(transaction.getAmount().replace("$", ""));
            accountFrom.setBalance(String.valueOf(from) + "0$");
            accountTo.setBalance(String.valueOf(to) + "0$");
        }

        String totalTransfers() {
            return String.valueOf(totalTransfers + "0$");
        }

        String totalProvision() {
            return String.valueOf(totalProvisions + "0$");
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Name: ");
            stringBuilder.append(name);
            stringBuilder.append("\n\n");
            for (Account acc : accounts) {
                stringBuilder.append(acc.toString());
            }
            ;
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        String test_type = jin.nextLine();
        switch (test_type) {
            case "typical_usage":
                testTypicalUsage(jin);
                break;
            case "equals":
                testEquals();
                break;
        }
        jin.close();
    }

    private static void testEquals() {
        Account a1 = new Account("Andrej", "20.00$");
        Account a2 = new Account("Andrej", "20.00$");
        Account a3 = new Account("Andrej", "30.00$");
        Account a4 = new Account("Gajduk", "20.00$");
        List<Account> all = Arrays.asList(a1, a2, a3, a4);
        if (!(a1.equals(a1) && !a1.equals(a2) && !a2.equals(a1) && !a3.equals(a1)
                && !a4.equals(a1)
                && !a1.equals(null))) {
            System.out.println("Your account equals method does not work properly.");
            return;
        }
        Set<Long> ids = all.stream().map(Account::getId).collect(Collectors.toSet());
        if (ids.size() != all.size()) {
            System.out.println("Different accounts have the same IDS. This is not allowed");
            return;
        }
        FlatAmountProvisionTransaction fa1 = new FlatAmountProvisionTransaction(10, 20, "20.00$", "10.00$");
        FlatAmountProvisionTransaction fa2 = new FlatAmountProvisionTransaction(20, 20, "20.00$", "10.00$");
        FlatAmountProvisionTransaction fa3 = new FlatAmountProvisionTransaction(20, 10, "20.00$", "10.00$");
        FlatAmountProvisionTransaction fa4 = new FlatAmountProvisionTransaction(10, 20, "50.00$", "50.00$");
        FlatAmountProvisionTransaction fa5 = new FlatAmountProvisionTransaction(30, 40, "20.00$", "10.00$");
        FlatPercentProvisionTransaction fp1 = new FlatPercentProvisionTransaction(10, 20, "20.00$", 10);
        FlatPercentProvisionTransaction fp2 = new FlatPercentProvisionTransaction(10, 20, "20.00$", 10);
        FlatPercentProvisionTransaction fp3 = new FlatPercentProvisionTransaction(10, 10, "20.00$", 10);
        FlatPercentProvisionTransaction fp4 = new FlatPercentProvisionTransaction(10, 20, "50.00$", 10);
        FlatPercentProvisionTransaction fp5 = new FlatPercentProvisionTransaction(10, 20, "20.00$", 30);
        FlatPercentProvisionTransaction fp6 = new FlatPercentProvisionTransaction(30, 40, "20.00$", 10);
        if (fa1.equals(fa1) &&
                !fa2.equals(null) &&
                fa2.equals(fa1) &&
                fa1.equals(fa2) &&
                fa1.equals(fa3) &&
                !fa1.equals(fa4) &&
                !fa1.equals(fa5) &&
                !fa1.equals(fp1) &&
                fp1.equals(fp1) &&
                !fp2.equals(null) &&
                fp2.equals(fp1) &&
                fp1.equals(fp2) &&
                fp1.equals(fp3) &&
                !fp1.equals(fp4) &&
                !fp1.equals(fp5) &&
                !fp1.equals(fp6)) {
            System.out.println("Your transactions equals methods do not work properly.");
            return;
        }
        Account[] accounts = new Account[]{a1, a2, a3, a4};
        Account[] accounts1 = new Account[]{a2, a1, a3, a4};
        Account[] accounts2 = new Account[]{a1, a2, a3};
        Account[] accounts3 = new Account[]{a1, a2, a3, a4};

        Bank b1 = new Bank("Test", accounts);
        Bank b2 = new Bank("Test", accounts1);
        Bank b3 = new Bank("Test", accounts2);
        Bank b4 = new Bank("Sample", accounts);
        Bank b5 = new Bank("Test", accounts3);

        if (!(b1.equals(b1) &&
                !b1.equals(null) &&
                !b1.equals(b2) &&
                !b2.equals(b1) &&
                !b1.equals(b3) &&
                !b3.equals(b1) &&
                !b1.equals(b4) &&
                b1.equals(b5))) {
            System.out.println("Your bank equals method do not work properly.");
            return;
        }
        //accounts[2] = a1;
        if (!b1.equals(b5)) {
            System.out.println("Your bank equals method do not work properly.");
            return;
        }
        long from_id = a2.getId();
        long to_id = a3.getId();
        Transaction t = new FlatAmountProvisionTransaction(from_id, to_id, "3.00$", "3.00$");
        b1.makeTransaction(t);
        if (b1.equals(b5)) {
            System.out.println("Your bank equals method do not work properly.");
            return;
        }
        b5.makeTransaction(t);
        if (!b1.equals(b5)) {
            System.out.println("Your bank equals method do not work properly.");
            return;
        }
        System.out.println("All your equals methods work properly.");
    }

    private static void testTypicalUsage(Scanner jin) {
        String bank_name = jin.nextLine();
        int num_accounts = jin.nextInt();
        jin.nextLine();
        Account accounts[] = new Account[num_accounts];
        for (int i = 0; i < num_accounts; ++i)
            accounts[i] = new Account(jin.nextLine(), jin.nextLine());
        Bank bank = new Bank(bank_name, accounts);
        while (true) {
            String line = jin.nextLine();
            switch (line) {
                case "stop":
                    return;
                case "transaction":
                    String descrption = jin.nextLine();
                    String amount = jin.nextLine();
                    String parameter = jin.nextLine();
                    int from_idx = jin.nextInt();
                    int to_idx = jin.nextInt();
                    jin.nextLine();
                    Transaction t = getTransaction(descrption, from_idx, to_idx, amount, parameter, bank);
                    System.out.println("Transaction amount: " + t.getAmount());
                    System.out.println("Transaction description: " + t.getDescription());
                    System.out.println("Transaction successful? " + bank.makeTransaction(t));
                    break;
                case "print":
                    System.out.println(bank.toString());
                    System.out.println("Total provisions: " + bank.totalProvision());
                    System.out.println("Total transfers: " + bank.totalTransfers());
                    System.out.println();
                    break;
            }
        }
    }

    private static Transaction getTransaction(String description, int from_idx, int to_idx, String amount, String o, Bank bank) {
        switch (description) {
            case "FlatAmount":
                return new FlatAmountProvisionTransaction(bank.getAccounts()[from_idx].getId(),
                        bank.getAccounts()[to_idx].getId(), amount, o);
            case "FlatPercent":
                return new FlatPercentProvisionTransaction(bank.getAccounts()[from_idx].getId(),
                        bank.getAccounts()[to_idx].getId(), amount, Integer.parseInt(o));
        }
        return null;
    }


}

