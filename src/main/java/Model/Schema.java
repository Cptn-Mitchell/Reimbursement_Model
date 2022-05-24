package Model;

import static java.sql.JDBCType.VARCHAR;
import static java.text.Collator.PRIMARY;

public class Schema {
    CREATE TABLE ers_users(
         id SERIAL PRIMARY KEY
            String username = new String

         username VARCHAR (250) UNIQUE NOT NULL,
         password VARCHAR (250) UNIQUE NOT NULL,
         role VARCHAR (250) NOT NULL
    );

    CREATE TABLE ers_reimbursements(
            id SERIAL PRIMARY KEY,
            author INT NOT NULL,
            resolver INT

            description TEXT NOT NULL
            type VARCHAR (250) NOT NULL,
            status VARCHAR (250) NOT NULL,
            amount FLOAT NOT NULL,
            CONSTRAINTS fk_author
                    FOREIGN KEY (author)
                        REFERENCES ers_users(id),
            CONSTRAINTS fk_resolver
                FOREIGN KEY (resolver)
                    REFERENCES ers_users(id)



    );
    DROP TABLE IF EXISTS ers_users CASCADE;
    DROP TABLE IF EXISTS ers_reimbursements CASCADE;

    create type role as enum ('Employee' , 'Manager');
    create type type as enum ('Lodging', 'Travel', 'Food', 'Other');
    create type status as enum('Pending' , 'Approved' , 'Denied');

    INSERT INTO ers_users (username, password, role) VALUES('default' , 'guest' , 'employee'),('admin' , 'admin' , 'manager');
}
