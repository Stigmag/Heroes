package com.example.demo.map;

import lombok.Builder;

import java.util.*;


public class ThreeNode {
    public ThreeNode(Node parent, Set<Node> child) {
        this.parent = parent;
        this.child = child;
    }





    Node parent;
    Set<Node> child = new HashSet<>();


    //x,y
  /* public  void findPathBetweenPoints(Point start, Point finish, byte[][] map) {
       Set<Node> visitedNodes = new HashSet<>();



        checkAndAddNode(start.plusX(), map).ifPresent(visitedNodes::add);
        checkAndAddNode(start.minusX(), map).ifPresent(visitedNodes::add);
        checkAndAddNode(start.plusY(), map).ifPresent(visitedNodes::add);
        checkAndAddNode(start.minusY(), map).ifPresent(visitedNodes::add);
        checkAndAddNode(finish.plusX(), map).ifPresent(visitedNodes::add);
        checkAndAddNode(finish.minusX(), map).ifPresent(visitedNodes::add);
        checkAndAddNode(finish.plusY(), map).ifPresent(visitedNodes::add);
        checkAndAddNode(finish.minusY(), map).ifPresent(visitedNodes::add);
    }*/

    public void createChild(Point start, Point finish, byte[][] map, Node node) {
        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> visitedParent = new HashSet<>();
        //Node nodeStart = new Node(start,visitedNodes);


        {

            checkAndAddNode(new Point(start.getX() + 1, start.getY()), map).ifPresent(node.nextNodes::add);
            checkAndAddNode(new Point(start.getX() - 1, start.getY()), map).ifPresent(node.nextNodes::add);
            checkAndAddNode(new Point(start.getX(), start.getY() + 1), map).ifPresent(node.nextNodes::add);
            checkAndAddNode(new Point(start.getX(), start.getY() - 1), map).ifPresent(node.nextNodes::add);
            if (!isPresentPoint(node.point))
                child.add(node);
            for (Node currentNode : node.nextNodes
            ) {
                if (!checkGoalFinish(node.point, finish)) {
                    currentNode.parents.add(node);
                    createChild(currentNode.point, finish, map, currentNode);
                }
            }
            //  graph.add(new ThreeNode(nodeStart,nodeStart.nextNodes));

        }
    }


    public void createTreeNode(Point start, Point finish, byte[][] map) {

        if (child.isEmpty()) {


            this.parent = Node.builder().point(start).nextNodes(new HashSet<>()).build();
            createChild(start, finish, map, this.parent);
        }

        /*while (!parent.nextNodes.isEmpty()) {
            for (Node currentNode : parent.nextNodes
            ) {


                createChild(currentNode.point, finish, map);


            }
            if (checkGoalFinish(parent.point, finish)) {
                break;
            }

        }*/

    }

    private boolean checkGoalFinish(Point currentPoint, Point finish) {
        return currentPoint.getX() == finish.getX() && currentPoint.getY() == finish.getY();
    }

    private Optional<Node> checkAndAddNode(Point point, byte[][] map) {
        //   if(point.equals(parent)) return Optional.empty();
        if (canMove(point, map) && !(isPresentPoint(Node.builder().point(point).build().point))) {
            return Optional.of(Node.builder().point(point).build());
        }
        //new Node().builder.point(point).build);

        return Optional.empty();

    }
    public ArrayList<Point> getPath(Point finish, ThreeNode three)
    {int k=0;
        Node node= null;
        ArrayList<Point> path= new ArrayList<>();
     ArrayList<Node> nodes= new ArrayList<>(three.child);
    for(Node currentNode: three.child)
        if(currentNode.point.equals(finish))
        {  node= currentNode;
           while(node.parents.iterator().hasNext()  )
            {

            path.add(node.getParents());
            node=node.parents.iterator().next();

            }
        }

        return path;
    }

    private boolean isPresentPoint(Point point) {
        for (Node node : child) {
            if (node.point.getX() == point.getX() && node.point.getY() == point.getY()) {
                return true;
            }

        }
        return false;
    }


    private boolean canMove(Point point, byte[][] map) {

        if (point.getX() < MyMap.mapArray[0] && point.getY() < MyMap.mapArray[1] && point.getX() >= 0 && point.getY() >= 0)
            return (map[point.getX()][point.getY()] == (byte) 11);
        else return false;
    }

    @Builder
    private static class Node {
        Point point;
        Set<Node> nextNodes = new HashSet<>();
        Set<Node> parents = new HashSet<>();

        public Node(Point point, Set<Node> visitedNodes, Set<Node> parent) {
            this.point = point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return point.equals(node.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(point);
        }


        public Point getParents() {
            return parents.iterator().next().point;
        }
    }

}
