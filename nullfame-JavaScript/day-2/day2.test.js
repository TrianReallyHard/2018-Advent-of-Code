import {
  warehouseBoxIdComparator,
  warehouseBoxRudimentaryChecksummer
} from "./day2.util";

const boxesToChecksum = [
  "abcdef",
  "bababc",
  "abbcde",
  "abcccd",
  "aabcdd",
  "abcdee",
  "ababab"
];

test("Day 2, Part 1", () => {
  expect(warehouseBoxRudimentaryChecksummer(boxesToChecksum)).toBe(12);
});

const boxesToCompare = [
  "abcde",
  "fghij",
  "klmno",
  "pqrst",
  "fguij",
  "axcye",
  "wvxyz"
];

test("Day 2, Part 2", () => {
  expect(warehouseBoxIdComparator(boxesToCompare)).toBe("fgij");
});
