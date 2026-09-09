SELECT * FROM customer;

SELECT * FROM customer WHERE state = 'AZ';

SELECT * from invoice WHERE invoice_date < NOW() - Interval '6 months';

UPDATE customer SET phone = NULL WHERE phone !~ '^\+1 \d{3} \d{3}-\d{3}';

SELECT * from track WHERE milliseconds > 180000;

UPDATE customer SET country = 'USA', address = NULL, city = NULL, state = NULL WHERE country != 'USA';

CREATE OR REPLACE FUNCTION get_invoice_total(p_id INT)
RETURNS NUMERIC AS $$
SELECT SUM(total) FROM invoice WHERE customer_id = p_id;
$$ LANGUAGE sql;

SELECT get_invoice_total(50);

CREATE PROCEDURE update_employee_report(p_employee_id INT, p_new_manager_id INT)
LANGUAGE plpgsql
AS $$
DECLARE is_circular BOOLEAN;
BEGIN
    IF p_employee_id = p_new_manager_id THEN
        RAISE EXCEPTION 'Employee cannot report to themselves';
    END IF;

    IF p_new_manager_id IS NOT NULL AND NOT EXISTS(
        SELECT 1 FROM employee WHERE employee_id = p_new_manager_id
    ) THEN 
        RAISE EXCEPTION 'Manager is non-existing employee';
    END IF;

    IF p_new_manager_id IS NOT NULL THEN 
        WITH RECURSIVE management_chain AS(
            SELECT employee_id, reports_to FROM employee WHERE employee_id = p_new_manager_id
            UNION ALL
            SELECT e.employee_id, e.reports_to FROM employee e 
            INNER JOIN management_chain mc ON e.employee_id = mc.reports_to
        )
        SELECT EXISTS(
            SELECT 1 FROM management_chain WHERE reports_to = p_employee_id
        ) INTO is_circular;

        IF is_circular THEN 
        RAISE EXCEPTION 'Circular management will be created.';
        END IF;

    END IF;

    UPDATE employee SET reports_to = p_new_manager_id WHERE employee_id=p_employee_id;
END;
$$;

CREATE SCHEMA pets;

CREATE TABLE IF NOT EXISTS pets.Customers(
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS pets.Pets(
    pet_id INT PRIMARY KEY,
    pet_name VARCHAR(40) NOT NULL,
    pet_breed VARCHAR(40) NOT NULL,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES pets.Customers(customer_id)
);

INSERT INTO pets.Customers VALUES (1, 'Brandon', 'Vergara'), (2, 'Daisy','Vega');
INSERT INTO pets.Pets Values (1, 'Bubbles', 'Cur', 1), (2, 'Brownie', 'Chihuahua', 2);

SELECT * FROM pets.Customers JOIN pets.Pets ON pets.Customers.customer_id = pets.Pets.customer_id;