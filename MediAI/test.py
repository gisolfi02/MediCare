import os
import unittest
from main import *


class BotTest(unittest.TestCase):
    def test_sintomo_vuoto(self):
     assert invokeFunction(1) == 0

    def test_sintomo_invalido(self):

     assert invokeFunction(1) == -1

    def test_funzionamento(self):
      assert invokeFunction(1) == 5


