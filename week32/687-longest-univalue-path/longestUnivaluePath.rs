// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::rc::Rc;
use std::cell::RefCell;
impl Solution {
    pub fn longest_univalue_path(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        fn search_longest_value(node: &Rc<RefCell<TreeNode>>, value: i32, result: &mut i32) -> i32 {
            let cell = node.borrow();
            let left = if let Some(left_node) = &cell.left {
                let searched = search_longest_value(left_node, cell.val, result);
                if left_node.borrow().val == cell.val {
                    searched + 1
                } else { 0 }
            } else { 0 };
            let right = if let Some(right_node) = &cell.right {
                let searched = search_longest_value(right_node, cell.val, result);
                if right_node.borrow().val == cell.val {
                    searched + 1
                } else { 0 }
            } else { 0 };
            *result = std::cmp::max(*result, left + right);
            if value == cell.val {
                std::cmp::max(left, right)
            } else { 0 }
        }
        match &root {
            None => 0,
            Some(cell) => {
                let mut result = 0;
                search_longest_value(cell, cell.borrow().val, &mut result);
                result
            },
        }
    }
}
