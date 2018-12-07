import { warehouseBoxRudimentaryChecksummer } from "./day2.util";

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
