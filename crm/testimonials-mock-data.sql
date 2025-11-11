-- insert testimonial values
insert into testimonials (id, title, description, result, image_url, content_type, creation_date, last_update, show_on_website, project_id)
values (1, 'Exzellente Zusammenarbeit', 'Das Projekt wurde strukturiert umgesetzt und die Kommunikation war stets professionell.', 5, '1.png', 'image/png', '2025-08-01', '2025-08-10', true, 1);
insert into testimonials (id, title, description, result, image_url, content_type, creation_date, last_update, show_on_website, project_id)
values (2, 'Schnelle Implementierung', 'Das Dashboard ist performant und wurde termingerecht geliefert.', 4, '2.png', 'image/png', '2025-08-02', '2025-08-11', true, 2);
insert into testimonials (id, title, description, result, image_url, content_type, creation_date, last_update, show_on_website, project_id)
values (3, 'Hoher Mehrwert', 'Durch die Prozessberatung konnten wir unsere Effizienz deutlich steigern.', 5, '3.png', 'image/png', '2025-08-03', '2025-08-12', true, 3);
insert into testimonials (id, title, description, result, image_url, content_type, creation_date, last_update, show_on_website, project_id)
values (4, 'Technologisch überzeugend', 'Die IoT-Plattform läuft stabil und erfüllt alle Anforderungen.', 5, '4.png', 'image/png', '2025-08-04', '2025-08-13', true, 4);

-- insert into auth_tokens values
insert into auth_tokens (id, value, valid, used, project_id, testimonial_id)
values (1, 'MV8zZjBjNWIyYS04YzFkLTRiNmEtOWYzZS0yYTdmOGMxYjlkNGU=', true, false, 1, 1);
insert into auth_tokens (id, value, valid, used, project_id, testimonial_id)
values (2, 'Ml8zZjBjNWIyYS04YzFkLTRiNmEtOWYzZS0yYTdmOGMxYjlkNGU=', true, false, 2, 2);
insert into auth_tokens (id, value, valid, used, project_id, testimonial_id)
values (3, 'M18zZjBjNWIyYS04YzFkLTRiNmEtOWYzZS0yYTdmOGMxYjlkNGU=', true, false, 3, 3);
insert into auth_tokens (id, value, valid, used, project_id, testimonial_id)
values (4, 'NF8zZjBjNWIyYS04YzFkLTRiNmEtOWYzZS0yYTdmOGMxYjlkNGU=', true, false, 4, 4);
