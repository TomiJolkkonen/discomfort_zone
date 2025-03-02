// linear search; if you see it, give true, if not, give false

export default function linear_search(haystack: number[], needle: number): boolean {

  for (let i = 0; i < haystack.length; i++) {
     if (haystack[i] === needle) {
      return true;
    }
  }

  return false;
}
