interface CoursePart {
  name: string;
  exerciseCount: number;
}

const courseParts: CoursePart[] = [
  {
    name: "Fundamentals",
    exerciseCount: 10
  },
  {
    name: "Using props to pass data",
    exerciseCount: 7
  }
];

console.log(courseParts);