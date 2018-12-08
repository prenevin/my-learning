# My Learning
The intention of this repo is for me to play with code and learn new stuff.
Using Spring boot as a base line.


## Domain
A Knight as a Sword. A Blacksmith has Tools. A Blacksmith repairs Swords.   

## Package structure:
Base on https://martinfowler.com/articles/microservice-testing/#anatomy-modules 

### Why do I have service.api and service.impl
This is so that there is a clear separation from the contact and implementation.

Later on I plan to play with maven modules and play around with the implementations with out affecting the other layers
(E.g switch out my JPA repo layer for a NoSQL repo, or JOOQ)
