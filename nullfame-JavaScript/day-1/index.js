const fs = require("fs");

fs.readFile("./day-1/input.txt", "utf-8", (err, data) => {
  if (err) throw err;
  const lines = data.trim().split("\n");

  // Part 1
  const result = lines.reduce(
    (total, current) => total + Number.parseInt(current),
    0
  );
  process.stdout.write(`${result}\n`);

  // Part 2
  let currentValue = 0;
  const previousValues = {};
  let answer = false;
  let i = 0;
  while (answer === false) {
    currentValue += Number.parseInt(lines[i]);
    if (typeof previousValues[currentValue] === "undefined") {
      previousValues[currentValue] = true;
    } else {
      answer = currentValue;
    }
    i = (i + 1) % lines.length;
  }
  process.stdout.write(`${answer}\n`);
});
