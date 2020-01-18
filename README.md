# simple-data-miner
This is an app that receives a input file (CSV type for now) and generates an output file with some additional data, like:
  1. Current Number
  2. Show if current number is either EVEN or ODD
  3. Show the integer multiple of 17 for current number (f(n) = number / 17)
  4. Show the mod of number/17
  
For example:
  - **input.csv**
   *line 2*: 5266
  - **output.csv**
  *line 2* 5266,EVEN,309,13

## Frameworks
 - Spring Batch

## How to build/run
 - Use Maven: 
   - insert the *input.csv* into: **?**
   - *mvn clean package*
   - *mvn spring-boot:run*
   - check the *output.csv* at: **?**

## Code Architecture
Get my draw.io [here](https://drive.google.com/open?id=1ap8M45Ma9e0CJ4CweRkKaiL1O649jB2m)

## Repositories

 - https://github.com/rscabral
 
## Authors

 * **Rafael Cabral** * - *Just a geek guy* - [Linkedin](https://www.linkedin.com/in/rafael-cabral-9679b498/)
