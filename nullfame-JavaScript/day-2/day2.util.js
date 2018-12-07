export const warehouseBoxRudimentaryChecksummer = boxes => {
  // Track how many boxes have a letter with exactly that many counts
  // e.g., boxesWithLetterCounts[1] = 2; // means 2 boxes have exactly 1 letter
  const boxesWithLetterCounts = {};

  // Loop the boxes
  boxes.forEach(box => {
    // Count the number of times each letter occurs in this box
    const letterCount = {};
    box.split("").forEach(letter => {
      if (Object.keys(letterCount).includes(letter)) {
        letterCount[letter] += 1;
      } else {
        letterCount[letter] = 1;
      }
    });

    // Figure out how many unique letter counts we have
    const uniqueLetterCounts = Array.from(new Set(Object.values(letterCount)));

    // Update boxesWithLetterCounts
    uniqueLetterCounts.forEach(count => {
      if (Object.keys(boxesWithLetterCounts).includes(String(count))) {
        boxesWithLetterCounts[count] += 1;
      } else {
        boxesWithLetterCounts[count] = 1;
      }
    });
  });

  // Multiply boxes that contain a letter exactly twice with exactly thrice
  return boxesWithLetterCounts[2] * boxesWithLetterCounts[3];
};
