<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Routing\Annotation\Route;

class MainController extends AbstractController
{
    /**
     * @Route("/", name="main_index")
     */
    public function index() {
        return $this->render('main/index.html.twig');
    }

    /**
     * @Route("/home", name="main_home")
     */
    public function home()
    {
        return $this->render('main/home.html.twig');
    }
}