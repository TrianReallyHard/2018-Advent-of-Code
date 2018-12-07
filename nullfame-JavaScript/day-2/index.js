import fs from "fs";
import {
  warehouseBoxIdComparator,
  warehouseBoxRudimentaryChecksummer
} from "./day2.util";

fs.readFile("./day-2/input.txt", "utf-8", (err, data) => {
  if (err) throw err;
  const lines = data.trim().split("\n");
  process.stdout.write(`${warehouseBoxRudimentaryChecksummer(lines)}\n`);
  process.stdout.write(`${warehouseBoxIdComparator(lines)}\n`);
});
