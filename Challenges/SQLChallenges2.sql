-- Get all invoice ids with the customers first name, last name, and the invoice total.
SELECT i.invoice_id, c.first_name, c.last_name, i.total AS invoice_total
FROM invoice i
INNER JOIN customer c
    ON i.customer_id = c.customer_id;


--Print the invoice id, customer's first name, and invoice total. But only if the invoice is over $30.
SELECT i.invoice_id, c.first_name, i.total AS invoice_total
FROM invoice i
INNER JOIN customer c
    ON i.customer_id = c.customer_id
    WHERE i.total > 30;


-- Get all the invoices for USA customers in the last 6 months. Use a CTE. 
WITH us_customers AS(
    SELECT customer_id
    FROM customer
    WHERE country = 'USA'
)
SELECT *
FROM invoice 
WHERE invoice_date < NOW() - INTERVAL '6 months'
AND customer_id IN (
    SELECT customer_id
    FROM us_customers
);

/*Create a new table called record_logs
Fields: log_id, record_id, field_changed, last_update, old_value, new_value
*/
CREATE TABLE IF NOT EXISTS record_logs(
    log_id INT PRIMARY KEY,
    record_id INT NOT NULL,
    field_changed VARCHAR(40) NOT NULL,
    last_update TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    old_value VARCHAR(40),
    new_value VARCHAR(40),
    FOREIGN KEY(record_id) REFERENCES customer(customer_id)
);


-- Create a trigger that tracks changes to customer records and logs the changes in our new table
CREATE OR REPLACE FUNCTION update_record_logs()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
IF(OLD.first_name IS DISTINCT FROM NEW.first_name) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'first_name', OLD.first_name, NEW.first_name);
END IF;

IF(OLD.last_name IS DISTINCT FROM NEW.last_name) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'last_name', OLD.last_name, NEW.last_name);
END IF;

IF(OLD.company IS DISTINCT FROM NEW.company) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'company', OLD.company, NEW.company);
END IF;

IF(OLD.address IS DISTINCT FROM NEW.address) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'address', OLD.address, NEW.address);
END IF;

IF(OLD.city IS DISTINCT FROM NEW.city) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'city', OLD.city, NEW.city);
END IF;

IF(OLD.state IS DISTINCT FROM NEW.state) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'state', OLD.state, NEW.state);
END IF;

IF(OLD.country IS DISTINCT FROM NEW.country) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'country', OLD.country, NEW.country);
END IF;

IF(OLD.postal_code IS DISTINCT FROM NEW.postal_code) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'postal_code', OLD.postal_code, NEW.postal_code);
END IF;

IF(OLD.phone IS DISTINCT FROM NEW.phone) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'phone', OLD.phone, NEW.phone);
END IF;

IF(OLD.fax IS DISTINCT FROM NEW.fax) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'fax', OLD.fax, NEW.fax);
END IF;

IF(OLD.email IS DISTINCT FROM NEW.email) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'email', OLD.email, NEW.email);
END IF;

IF(OLD.support_rep_id IS DISTINCT FROM NEW.support_rep_id) THEN
    INSERT INTO record_logs (record_id, field_changed, old_value, new_value)
    VALUES (OLD.customer_id, 'support_rep_id', OLD.support_rep_id, NEW.support_rep_id);
END IF;

RETURN NEW;
END;
$$;

CREATE TRIGGER record_logs_update
BEFORE UPDATE ON customer
FOR EACH ROW
EXECUTE FUNCTION update_record_logs();