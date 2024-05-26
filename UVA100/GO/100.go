package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func convert(line string) []int {
	input := strings.Fields(line)
	values := []int{}
	for _, field := range input {

		num, err := strconv.Atoi(field)
		if err == nil {
			values = append(values, num)
		}
	}
	return values
}

func main() {

	scanner := bufio.NewScanner(os.Stdin)
	for scanner.Scan() {

		line := scanner.Text()
		if line == "" {
			break
		}

		values := convert(line)
		count := 0

		i := int(math.Min(float64(values[0]), float64(values[1])))
		j := int(math.Max(float64(values[0]), float64(values[1])))
		for k := i; k <= j; k++ {
			count = int(math.Max(float64(count), float64(dp(k))))
		}

		fmt.Printf("%d %d %d\n", values[0], values[1], count)
	}
}

func dp(i int) int {

	if i == 1 {
		return 1
	}
	if i%2 != 0 {
		return 1 + dp(3*i+1)

	} else {
		return 1 + dp(i/2)

	}
}
