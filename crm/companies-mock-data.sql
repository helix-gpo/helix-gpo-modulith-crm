-- insert company values
insert into companies (id, name, legal_form, tax_number, vat_id)
values (1, 'Aventra Systems GmbH', 'GmbH', '123/456/7890', 'DE123456789');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (2, 'Nordic Consult AG', 'AG', '987/654/3210', 'DE987654321');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (3, 'BluePeak Innovations UG', 'UG', '112/233/4455', 'DE112233445');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (4, 'EcoTech Solutions AG', 'AG', '667/788/9900', 'DE667788990');
insert into companies (id, name, legal_form, tax_number, vat_id)
values (5, 'DataCore SE', 'SE', '554/433/2211', 'DE554433221');

-- insert into addresses
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (1, 'Innovationsallee', '5', '3. OG', 'Berlin', '10117', 'Germany', 1);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (2, 'Beraterring', '18', null, 'München', '80333', 'Germany', 2);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (3, 'Hansebogen', '9', null, 'Hamburg', '20097', 'Germany', 3);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (4, 'Nachhaltigkeitsweg', '22', null, 'Stuttgart', '70174', 'Germany', 4);
insert into addresses (id, street, number, address_addition, city, zip_code, state, company_id)
values (5, 'Digitalstraße', '77', null, 'Frankfurt am Main', '60313', 'Germany', 5);

-- insert into bank_details values
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (1, 'Aventra Systems GmbH', 'DE89370400440532013000', 'COBADEFFXXX', 'Commerzbank', 'DE', 1);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (2, 'Nordic Consult AG', 'DE44500105175407324931', 'INGDDEFFXXX', 'ING', 'DE', 2);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (3, 'BluePeak Innovations UG', 'DE12500105170648489890', 'DEUTDEFFXXX', 'Deutsche Bank', 'DE', 3);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (4, 'EcoTech Solutions AG', 'DE22500105177891011121', 'BYLADEMMXXX', 'Sparkasse', 'DE', 4);
insert into bank_details (id, account_holder_name, iban, bic, bank_name, country, company_id)
values (5, 'DataCore SE', 'DE66500105176543219876', 'PBNKDEFFXXX', 'Postbank', 'DE', 5);
