# helix-gpo-modulith-crm
A modulithic crm for the company providing a crm conntected to our website as well.

# Structure (DDD)

## Entities:
- Companies
- Addresses (company, partner)
- BankDetails (company, partner)

- Partners (company)

- Projects (partner)
- (ProjectStatus)
- (ProjectTag)
- Milestones (project)
- (MilestoneStatus)
- Invoices (milestone)
- (InvoiceStatus)

- Testimonials (project)
- AuthToken (testimonial, partner)

## Use Cases (Website):
- get all website projects
- get all website testimonials
- get testimonials average rating
- create testimonial

## Use Cases (CRM):
- ...


## Structure in Modules:
com.helixgpo
├── HelixGpoApplication.java
├── modules
│   ├── company
│   │   ├── package-info.java (siehe unten)
│   │   ├── domain
│   │   │   ├── Company.java
│   │   │   ├── Address.java
│   │   │   └── BankDetails.java
│   │   ├── repository
│   │   │   ├── CompanyRepository.java
│   │   │   └── AddressRepository.java
│   │   ├── service
│   │   │   └── CompanyService.java
│   │   └── web
│   │       └── CompanyController.java
│   ├── partner
│   │   ├── package-info.java
│   │   ├── domain
│   │   │   └── Partner.java
│   │   ├── repository
│   │   ├── service
│   │   └── web
│   ├── project
│   │   ├── package-info.java
│   │   ├── domain
│   │   │   ├── Project.java
│   │   │   ├── Milestone.java
│   │   │   ├── Invoice.java
│   │   └── …  
│   └── testimonial
│       ├── package-info.java
│       ├── domain
│       │   ├── Testimonial.java
│       │   └── AuthToken.java
│       └── …  
└── shared
├── config
├── awsservice [own domain!]
├── exception
├── payload
├── dto
├── security
└── util

## Dependencies:
1) spring web
2) lombok
3) jpa
4) mysql driver
5) actuator
6) validation
7) flyway
8) spring security
9) modulith
10) jmolecules-ddd
11) aws-project
12) commons-io

## Todos:
- Add Controller
- Create Methods in Testimonial Service
