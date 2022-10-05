use std::collections::HashMap;
use rand::distributions::{Distribution, Uniform};

#[derive(Debug)]
struct RandomizedSet {
    a: Vec<i32>,
    h: HashMap<i32, usize>
}

impl RandomizedSet {
    fn new() -> Self  {
        Self {
            a: vec!(),
            h: HashMap::new()
        }
    }

    fn insert(&mut self, val: i32) -> bool {
        match self.h.get(&val) {
            None => {
                self.a.push(val);
                self.h.insert(val, self.a.len() - 1);
                true
            }
            Some(_) => false
        }
    }

    fn remove(&mut self, val: i32) -> bool {
        match self.h.get(&val) {
            None => false,
            Some(v) => {
                let last_index = self.a.len() - 1;
                self.a[*v] = self.a[last_index];
                self.h.insert(self.a[last_index], *v);
                self.h.remove(&val);
                self.a.remove(last_index);
                true
            }
        }
    }
    
    fn get_random(&self) -> i32 {
        let between = Uniform::new(0, self.a.len());
        let mut rng = rand::thread_rng();
        let random_index = between.sample(&mut rng);
        self.a[random_index]
    }

}




fn main() {
    println!("Hello, world!");
}
