impl Solution {
    pub fn average(salary: Vec<i32>) -> f64 { 
        let max = salary.iter().max().unwrap();
        let min = salary.iter().min().unwrap();
        let filtered: Vec<i32> = salary.iter()
            .filter(|&x| x != max)
            .filter(|&x| x != min)
            .cloned()
            .collect();
        (filtered.iter().sum::<i32>() as f64) / (filtered.len() as f64)
      }
}
