# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Name Test

Checking for valid name data

### Test Data To Use

player 1 name and player 2 name

### Expected Test Result

Code will not allow blank names and will re-ask until given data

---

## Counter-Blank test

checking for blank inputs when choosing counters.

### Test Data To Use

picking counter and moving counter

### Expected Test Result

Code will not allow blank counters and will re-ask until given data

---

## Picking counter test

Checking for valid counter pick

### Test Data To Use

blank squares and pick counter

### Expected Test Result

Code will not allow blank squares and will re-ask until given data

---

## Moving counter test

checking for correct code for moving counters

### Test Data To Use

blank squares with counters on or in-between pick counter

### Expected Test Result

Code will not allow squares in-between pick and move and squares with counter on it then it will re-ask until given correct data

---

## Player turns test

testing switching between player i.e. player turns

### Test Data To Use

all gameplay data

### Expected Test Result

game will run smoothly

---

## Player removes counters

removing x counters of square one

### Test Data To Use

x counter removed off square 1

### Expected Test Result

when square 1 is chosen with an x counter on it, it will be removed

---

## Player wins test

testing when o counter is removed game is ended

### Test Data To Use

o counter removed off square 1 

### Expected Test Result

when o counter removed game will end

---

## Replay game test

testing the replay game function

### Test Data To Use

the replay game function and game set-up

### Expected Test Result

when saying yes it should start a new game without asking for name and no should end it

---



