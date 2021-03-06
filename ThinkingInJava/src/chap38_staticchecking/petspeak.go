package main

import "fmt"

type Cat struct {}
    func (this Cat) speak() { fmt.Printf("meow!\n")}

type Dog struct {}
    func (this Dog) speak() { fmt.Printf("woof!\n")}

type Bob struct {}
    func (this Bob) bow() {
        fmt.Printf("thank you, thank you!\n")
    }

    func (this Bob) speak() {
        fmt.Printf("Welcome to the neighborhood!\n")
    }

    func (this Bob) drive() {
        fmt.Printf("beep, beep!\n")
    }

type Speaker interface {
    speak()
}

func command(s Speaker) { s.speak() }

// If "Speaker" is never used
// anywhere else, it can be anonymous:
func command2(s interface { speak() }) {
     s.speak()
}

func main() {
    command(Cat{})
    command(Dog{})
    command(Bob{})
    command2(Cat{})
    command2(Dog{})
    command2(Bob{})
}