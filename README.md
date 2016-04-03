# selenium-boilerplate

Boilerplate code for Selenium test scripts. Selenium Grid created with Docker.

## Setting up a Selenium Grid with Docker

Create a file name `docker-compose.yml` with the following content.

```YAML
selhub:  
  image: selenium/hub
  ports:
    - 4444:4444

nodeff:  
  image: selenium/node-firefox-debug
  ports:
    - 5900
  links:
    - selhub:hub

nodechrome:  
  image: selenium/node-chrome-debug
  ports:
    - 5900
  links:
    - selhub:hub
```  

Run `docker-compose up -d`

## Running Tests with Maven

Run `mvn test`
